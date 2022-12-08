import com.tom.bank.BankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount myAccount = null;
    @BeforeEach
    void setUp() {
        myAccount = new BankAccount();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void depositTest1() {
        myAccount.setBalance(200);
        assertEquals(300, myAccount.deposit(100));
    }

    @Test
    void depositTest2() {
        myAccount.setBalance(0);
        assertEquals(100, myAccount.deposit(100));
    }

    @Test
    void depositTest3() {
        myAccount.setBalance(-50);
        assertEquals(50, myAccount.deposit(100));
    }

    @Test
    void withdrawTest1() {
        myAccount.setBalance(200);
        assertEquals(150, myAccount.withdraw(50));
    }

    @Test
    void withdrawTest2() {
        myAccount.setBalance(100);
        assertEquals(-50, myAccount.withdraw(150));
    }
}