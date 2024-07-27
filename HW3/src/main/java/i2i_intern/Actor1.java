package i2i_intern;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;

public class Actor1 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("start", message -> {
                    String actor2Path = "akka://actor2System@127.0.0.1:2552/user/actor2";
                    ActorSelection actor2 = getContext().actorSelection(actor2Path);
                    actor2.tell("Hi from Actor1", getSelf());
                })
                .matchAny(message -> {
                    System.out.println(message);
                })
                .build();
    }
}
