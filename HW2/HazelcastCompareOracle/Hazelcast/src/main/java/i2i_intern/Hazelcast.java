package i2i_intern;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import java.util.Map;
import java.util.Random;

public class Hazelcast {

    public void HazelcastOperations() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("dev");
        clientConfig.getNetworkConfig().addAddress("159.89.229.126:5701");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Integer, Integer> map = client.getMap("i2i_intern");

        System.out.println("Put 20000 Data  Time Hazelcast: " + putData(map) + " ms");
        System.out.println("Get 20000 Data  Time Hazelcast: " + getData(map) + " ms");

        client.shutdown();
    }

    private long putData(IMap<Integer, Integer> map) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 20000; i++) {
            int randInt = new Random().nextInt();
            map.put(i, randInt);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    private long getData(IMap<Integer, Integer> map) {
        long start = System.currentTimeMillis();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.get(entry.getKey());
        }

        long end = System.currentTimeMillis();
        return end - start;
    }
}
