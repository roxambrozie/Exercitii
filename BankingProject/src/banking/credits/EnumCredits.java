package banking.credits;

public class EnumCredits {

    public enum Credits {
        MORTGAGE_CREDIT, REPAIRS_CREDIT, PERSONAL_NEEDS;

        public String toString() {
            switch (Enum.valueOf(Credits.class, this.name())) {
                case MORTGAGE_CREDIT:
                    return "MORTGAGE_CREDIT";
                case REPAIRS_CREDIT:
                    return "REPAIRS_CREDIT";
                case PERSONAL_NEEDS:
                    return "PERSONAL_NEEDS";
                default:
                    return "Null";
            }
        }
    }
}
