class KeyValueObject {

    private final String key;
    private String value;

    KeyValueObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    String getKey() {
    	return this.key;
    }

    String getValue() {
    	return this.value;
    }

    void updateValue(String newValue) {
    	this.value = newValue;
    }
}