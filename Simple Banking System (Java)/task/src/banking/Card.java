package banking;

import java.util.Random;

class Card{
    private Random rand = new Random();
    private int pinNumber;
    private String cardNumber;
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Card() {
        final int upperPinBound = 8001;
        final int lowerPinBound = 1000;
        balance = 0;
        pinNumber = rand.nextInt(upperPinBound)+lowerPinBound;
        cardNumber = generateCardNumber();
    }

    private String generateCardNumber(){
        StringBuilder stringNumber = new StringBuilder();
        stringNumber = new StringBuilder("400000");

        for(int i = 0 ; i < 9 ; i++){

            stringNumber.append(rand.nextInt(10));
        }
        stringNumber.append(generateLuhn(stringNumber.toString()));

        return stringNumber.toString();
    }

    private int generateLuhn(String carNumberWithoutChecksum){
        StringBuilder checksumNumber = new StringBuilder();

        int checksum = 0;
        int aux;
        for(int i = 0 ; i < carNumberWithoutChecksum.length() ; i++){
            if(i%2==0){
                aux = (carNumberWithoutChecksum.charAt(i) - '0') * 2;
                if(aux>9) aux -= 9;
                checksumNumber.append(aux);
            }
            else{
                checksumNumber.append(carNumberWithoutChecksum.charAt(i));
            }
        }

        for(int i = 0 ; i < checksumNumber.length() ; i++){
            checksum += checksumNumber.charAt(i) - '0';
        }
        checksum = (10-(checksum % 10))%10;

        return checksum;
    }

    public boolean isValidCardNumber(String cardNumberToCheck){
        if(!cardNumberToCheck.isEmpty()) {
            String cardNumberWithoutChecksum = cardNumberToCheck.substring(0, cardNumberToCheck.length() - 1);
            char checksum = cardNumberToCheck.charAt(cardNumberToCheck.length() - 1);
            char resultLuahChecksum = (char) ((char)generateLuhn(cardNumberWithoutChecksum) +'0');
            return  checksum ==
                    resultLuahChecksum;

        }else return false;
    }
}
