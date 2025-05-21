class SuperClassGetter {

    public Class getSuperClassByName(String name) throws ClassNotFoundException {

        return Class.forName(name).getSuperclass();
        // write your code here
    }

    public Class getSuperClassByInstance(Object object) {
        // write your code here
        return object.getClass().getSuperclass();
    }
}