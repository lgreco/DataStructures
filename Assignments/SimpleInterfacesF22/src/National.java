public interface National {

    /**
     * The form of goverment of a national entity, e.g.  parliamentary republic,
     * presidential republic, monarchy, etc.
     *
     * @return String with entity's form of government
     */
    public String formOfGovernment();

    /**
     * The name of the entity's monetary currency, e.g, Euro, Pound Sterling, etc
     * @return String with currency name.
     */
    public String currentName();


    /**
     * Information about the entity's capita. For example:
     *   usa.descriptCapital();
     * shall return the String
     *   "The capital of the US is Washington DC with population 702,000"
     *
     * @return String with the representation suggested above or similar.
     */
    public String describeCapital();

}
