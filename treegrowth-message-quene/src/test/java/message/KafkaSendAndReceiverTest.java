package message;


import com.treegrowth.message.quene.cofiguration.Config;
import com.treegrowth.message.quene.cofiguration.Receiver;
import com.treegrowth.message.quene.cofiguration.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Config.class, Receiver.class, Sender.class,KafkaSendAndReceiverTest.class})
public class KafkaSendAndReceiverTest {

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @Test
    public void testSimple() throws Exception {

        sender.sendMessage("tree.a", "hello kafka world");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(receiver.getLatch().getCount()).isEqualTo(0);

    }
}
