public class EligibleUSPresident implements CheckPerson {
    public boolean test(Person p) {
        return p.getAge() > 31 &&
                p.getCountryOfBirth().equals("USA");
    }
}
