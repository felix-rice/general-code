import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.felix.general.code.api.GeneralCodeApiApplication;
import com.felix.general.code.core.service.RedisService;

import jakarta.annotation.Resource;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-08-13
 */
@SpringBootTest(classes = GeneralCodeApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GeneralCodeCoreApplicationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralCodeCoreApplicationTest.class.getSimpleName());
    @Resource
    private RedisService redisService;

    @Test
    public void testPrint() {
        LOGGER.info("hello world");
    }

    @Test
    public void testRedisAdd() {
        redisService.set("name", "zhangsan");
    }

    @Test
    public void testRedisGet() {
        String s = redisService.get("name");
        LOGGER.info("ans: {}", s);
    }


}
