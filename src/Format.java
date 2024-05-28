class Format {
    public static String installPadezh(double rub) {
        int intPart = (int) Math.floor(rub);
        int lastDigit = intPart % 10;
        int lastDigit_2 = intPart % 100;
        String form = "%.2f рублей";

        if (lastDigit_2 >= 11 && lastDigit_2 <= 14) {
            String.format(form, rub);
        } else {
            switch (lastDigit) {
                case 1:
                    form = "%.2f рубль"; break;
                case 2, 3, 4:
                    form = "%.2f рубля"; break;
                default:
                    form = "%.2f рублей";
            }
        }
        return String.format(form, rub);
    }
}
