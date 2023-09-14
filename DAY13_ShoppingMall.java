import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 쇼핑몰 서비스 만들기
abstract class Product {// 상품 정보라는 것은 최소한 이정도의 정보는 꼭 가져야한다!
    int id;// 상품을 가리킬 식별자 값(유일해야함)
    int price;// 상품의 가격

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
abstract class Account {// 계정 정보라는 것은 최소한 이정도의 정보를 꼭 가져야한다!
    String userId;// 사용자의 계정
    String password;// 사용자의 비밀번호

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(userId, account.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}

interface ShoppingMall {
    // 상품 목록
    List<Product> getProducts();

    // 구매
    boolean buy(Product product, int priceFromCustomer);

    // 환불
    int refund(Product product);

    // 계정 관리
    void manageAccount(Account account) throws Exception;
}
abstract class StatefulShoppingMall implements ShoppingMall {
    // 쇼핑몰이 가져야할 최소한의 정보
}

class ElectronicShoppingMall extends StatefulShoppingMall {
    private List<Product> products = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Product> soldProducts = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean buy(Product product, int priceFromCustomer) {
        if(products.contains(product)) {
            // 고객이 지불한 금액 - 제품의 가격 = 최소한 0이상이어야 판매 가능
            boolean canSell = priceFromCustomer - product.price > 0;
            if(!canSell) {
                return false;
            }
            soldProducts.add(product);
            return canSell;
        }
        return false;
    }

    @Override
    public int refund(Product product) {
        int index = 0;
        if((index = soldProducts.indexOf(product)) >= 0) {
            Product soldProduct = soldProducts.get(index);
            return soldProduct.price;
        }
        return 0;
    }

    @Override
    public void manageAccount(Account account) throws Exception {
        if(accounts.contains(account)) {
            // 당장 구현하지 않겠다면, 다른 프로그래머가 알아차릴 수 있도록 표식 남기기!
            // TODO::관리 기능 만들기
            throw new Exception("");
        }
    }
}

public class DAY13_ShoppingMall {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
    }

    static class MyClass {}
}
