public interface Measurement<P> {

    /**
     * Usage:
     *
     *   Person mj = new Person("Michael Jordan", 78);
     *   Person li = new Person("Leo Irakliotis", 70);
     *
     *   li.isTaller(mj) ... should be: false
     *   mj.isTaller(li) ... should be: true
     *
     * Method compares the calling Person's height to the passed
     * person's height and returns true of the calling person is
     * taller; false otherwise.
     * @param p Person passed to the method
     * @return true is invoking person's height greater than passed person's
     */
    boolean isTaller(Person p);

}
