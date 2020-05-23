package system.dictionary;

import java.util.ArrayList;
import java.util.Iterator;

public interface Dictionary<T> {

        public Iterator<T> list();
        public T get (String id);
        public void  put(String id, T object );
        public ArrayList<T> values();
}
