import type {NextPage} from 'next'
import Link from 'next/link'

const Home: NextPage = () => {
    return (
       <div>
           <Link href="admin">
               <a>admin</a>
           </Link>
           <Link href="user">
               <a>user</a>
           </Link>
       </div>
    )
}

export default Home
