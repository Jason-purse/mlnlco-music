import {useMemo} from 'react'
import {createStore, PreloadedState, Store} from 'redux'
// import { composeWithDevTools } from 'redux-devtools-extension'
import reducers from './reducers'

let store: Store | undefined

function initStore(initialState: PreloadedState<any>) {
    return createStore(
        reducers,
        initialState
    )
}

export const initializeStore: (state: PreloadedState<any>) => Store = (preloadedState) => {
    let _store = store ?? initStore(preloadedState)
    // After navigating to a page with an initial Redux state, merge that state
    // with the current state in the store, and create a new store
    if (preloadedState && store) {
        _store = initStore({
            ...store.getState(),
            ...preloadedState,
        })
        // Reset the current store
        store = undefined
    }


    // For SSG and SSR always create a new store
    if (typeof window === 'undefined') {
        return _store
    }
    // Create the store once in the client
    if (!store) store = _store
    return _store
}

/**
 * 由于每次刷新 浏览器,导致对象重置 .... 所以会产生一个新的对象 ..
 * 但是如果是Link 在页面之间进行穿梭,使用的是同一个redux store对象 ....
 * @param initialState
 * @returns Store
 */
export function useStore(initialState: PreloadedState<any>): Store {
    // useMemo 是一个纯函数,当发生改变时,重新执行factory 方法 ...
    const store = useMemo(() => initializeStore(initialState), [initialState])
    if(typeof window === 'undefined') {
        console.log(`server store: ${JSON.stringify(store.getState())}`)
    }
    else {
        console.log(`client store: ${JSON.stringify(store.getState())}`)
    }
    return store
}
