package banking.deposits;

import banking.credits.EnumCredits;

public class EnumDeposits {

    public enum Deposits {
        TERM_DEPOSIT, NO_TERM_DEPOSIT, COMMON_DEPOSIT;

        public String toString() {
            switch (Enum.valueOf(Deposits.class, this.name())) {
                case TERM_DEPOSIT:
                    return "TERM_DEPOSIT";
                case NO_TERM_DEPOSIT:
                    return "NO_TERM_DEPOSIT";
                case COMMON_DEPOSIT:
                    return "COMMON_DEPOSIT";
                default:
                    return "Null";
            }
        }

        public static Deposits getStringToEnum(String string){
            switch (string) {
                case "TERM_DEPOSIT":
                    return TERM_DEPOSIT;
                case "NO_TERM_DEPOSIT":
                    return NO_TERM_DEPOSIT;
                case "COMMON_DEPOSIT":
                    return COMMON_DEPOSIT;
                default:
                    return null;
            }
        }
    }
}
