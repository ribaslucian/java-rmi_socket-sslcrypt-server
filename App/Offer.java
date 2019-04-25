package App;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

class Offer extends UnicastRemoteObject implements OfferInterface {

    /**
     * Chaves validas:
     *
     * <ClientInterface> client
     * <Integer> id
     * <String> city
     * <String> hotel
     * <Integer> people
     * <String> dateDeparture
     * <String> dateReturn
     * <Float> maxPrice
     */
    public HashMap<String, Object> data = new HashMap< >();

    public Offer(HashMap data) throws RemoteException {
        super();
        this.data = data;
    }

    @Override
    public void put(String key, Object value) {
        data.put(key, value);
    }

    @Override
    public Object get(String key) {
        return data.get(key);
    }
    
    protected Offer() throws RemoteException {
        super();
    }

}
