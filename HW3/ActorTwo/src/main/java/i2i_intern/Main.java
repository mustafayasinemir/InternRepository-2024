package i2i_intern;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Main {
    public static void main(String[] args) {
        Config config1 = ConfigFactory.load("app1.conf");
        ActorSystem system1 = ActorSystem.create("actor1System", config1);
        ActorRef actor1 = system1.actorOf(Props.create(Actor1.class), "actor1");

        Config config2 = ConfigFactory.load("app2.conf");
        ActorSystem system2 = ActorSystem.create("actor2System", config2);
        system2.actorOf(Props.create(Actor2.class), "actor2");

        actor1.tell("start", ActorRef.noSender());
    }
}
