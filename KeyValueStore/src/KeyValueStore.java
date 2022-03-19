class KeyValueStore {

    private KeyValueObject[] store = new KeyValueObject[0];
    private String filename;

    KeyValueStore() {
        filename = "KeyValueStore.data";
    }

    /**
     * @param filename name of file to read from and write to
     */
    KeyValueStore(String filename) {
        readFromFile(filename);
    }

    /**
     * get index of key
     *
     * @param key key to find
     * @return index of found key or -1 if not found
     */
    private int indexOf(String key) {
        for (int i = 0; i < store.length; i++) {
            if (key.equals(store[i].getKey())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * add non existing key-value-pair
     *
     * @param key key to add
     * @param value value for key
     */
    void newElement(String key, String value) {
        newElement(new KeyValueObject(key, value));
    }

    /**
     * add non existing key-value-pair
     *
     * @param keyValueObject key-value-object to add
     */
    private void newElement(KeyValueObject keyValueObject)  {
        int index = this.indexOf(keyValueObject.getKey());
        if (index >= 0) {
        	return ;
        }
        KeyValueObject[] storeCopy = new KeyValueObject[store.length + 1];
        System.arraycopy(store, 0, storeCopy, 0, store.length);
        storeCopy[storeCopy.length - 1] = keyValueObject;
        store = storeCopy;
    }


    /**
     * update value of existing key
     *
     * @param key key to update
     * @param value value the key gets updated with
     */
    void update(String key, String value) {
        int index = this.indexOf(key);
        if (index < 0) {
        	return ;
        	// TODO: Exception();
        }
        store[index].updateValue(value);
    }

    /**
     * delete key
     *
     * @param key key to delete
     */
    void delete(String key) {
        int index = this.indexOf(key);
        if (index < 0) {
        	return ;
        	// TODO: Exception();
        }
        KeyValueObject[] storeCopy = new KeyValueObject[store.length - 1];
        for (int i = 0, j = 0; i < store.length; i++) {
            if (i != index) {
                storeCopy[j++] = store[i];
            }
        }
        store = storeCopy;
    }

    /**
     * get value of key
     *
     * @param key key to get value of
     * @return value of found key
     */
    String get(String key) {
        int index = this.indexOf(key);
        if (index < 0) {
        	return null;
        }
        return store[index].getValue();
    }

    @Override
    public String toString() {
        String inner = "{\n";
        for (KeyValueObject kvo : this.store) {
            inner += String.format("\tKVO{key=%s, value=%s},\n", kvo.getKey(), kvo.getValue());
        }
        return String.format("KVStore{size=%d, store=%s}", this.store.length, inner);
    }

    
    void readFromFile(String filename) {
    }

}