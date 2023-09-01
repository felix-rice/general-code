import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.felix.general.code.api.GeneralCodeApiApplication;
import com.felix.general.code.core.service.RedisService;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-08-13
 */
@SpringBootTest(classes = GeneralCodeApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GeneralCodeCoreApplicationTest {
    @Autowired
    private RedisService redisService;

}
