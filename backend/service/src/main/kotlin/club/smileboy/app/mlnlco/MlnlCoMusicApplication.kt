package club.smileboy.app.mlnlco

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
/**
 * @author JASONJ
 * @date 2022/7/8
 * @time 22:10
 * @description Mlnlco Spring boot application
 **/
@MapperScan(basePackages = ["club.smileboy.app.mlnlco.repository"])
@SpringBootApplication
class MlnlCoMusicApplication
fun main(args: Array<String>) {
    runApplication<MlnlCoMusicApplication>(*args)
}