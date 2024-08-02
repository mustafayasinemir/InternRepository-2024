package i2i_intern;

import org.voltdb.VoltTable;
import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.ClientFactory;
import org.voltdb.client.ClientResponse;

public class Main {

    public static void main(String[] args) {
        try {
            ClientConfig clientConfig = new ClientConfig();
            Client client = ClientFactory.createClient(clientConfig);

            client.createConnection("localhost:32772");

            ClientResponse response = client.callProcedure("GetAllSubscriber");

            if (response.getStatus() == ClientResponse.SUCCESS) {
                VoltTable results = response.getResults()[0];
                  while (results.advanceRow()) {
                    System.out.println("SUBSC_ID: " + results.getLong("SUBSC_ID") +
                            ", SUBSC_NAME: " + results.getString("SUBSC_NAME") +
                            ", SUBSC_SURNAME: " + results.getString("SUBSC_SURNAME") +
                            ", MSISDN: " + results.getString("MSISDN") +
                            ", TARIFF_ID: " + results.getLong("TARIFF_ID") +
                            ", START_DATE: " + results.getTimestampAsLong("START_DATE"));
                }
            } else {
                System.out.println("Prosedür çağrısı başarısız: " + response.getStatusString());
            }

            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
