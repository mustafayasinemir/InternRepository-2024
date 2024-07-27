package i2i_intern;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;

public class Actor2 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchAny(message -> {
                    System.out.println(message);
                    if (message.equals("Hi from Actor1")) {
                        String actor1Path = "akka://actor1System@127.0.0.1:2551/user/actor1";
                        ActorSelection actor1 = getContext().actorSelection(actor1Path);
                        actor1.tell("Hi from Actor2", getSelf());
                    }
                })
                .build();
    }
}
