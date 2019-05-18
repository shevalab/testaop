package com.shevalab.testaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestAopApplication implements CommandLineRunner {
 
    private static Logger LOG = LoggerFactory.getLogger(TestAopApplication.class);
    
    @Autowired
    private Component1 entity1;
    
    @Autowired
    private Component2 entity2;
    
    public static void main(String[] args) {
            SpringApplication.run(TestAopApplication.class, args);
    }
        
    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
  
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
        
        entity1.setProperty("value1").getProperty();
        entity2.setName("value1").getName();
        
        LOG.info("Made changes for Entity1 instance {}", entity1.getChanges());
    }        

}
