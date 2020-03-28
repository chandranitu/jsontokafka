package jsontokafka.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("producer")
public class ItemController {

    @Autowired
    KafkaTemplate<String, Item> KafkaJsontemplate;
    String TOPIC_NAME = "test1";

    @PostMapping(value = "/postItem",consumes = {"application/json"},produces = {"application/json"})
    
    public String postJsonMessage(@RequestBody Item item){
        KafkaJsontemplate.send(TOPIC_NAME, new Item(1,"Lenovo","Laptop"));
        return "Message published successfully";
    }
}
