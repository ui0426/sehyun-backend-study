package com.sehyun.backend.java.stringexample;

public class ImmutableObjectExample {
    public static void main(String[] args) {
        Money money1 = new Money(1000);
        Money money2 = new Money(500);

        Money result = money1.add(money2);

        System.out.println("money1 = " + money1.getAmount());
        System.out.println("money2 = " + money2.getAmount());
        System.out.println("result = " + result.getAmount());
    }

    static class Money {

        private final int amount;

        public Money(int amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
            }

            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public Money add(Money other) {
            return new Money(this.amount + other.amount);
        }
    }
}
