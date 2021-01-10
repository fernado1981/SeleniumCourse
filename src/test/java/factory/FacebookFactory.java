package factory;

import org.testng.annotations.Factory;

public class FacebookFactory {

    @Factory
    public Object[] facebookFactory(){
        return new Object[]{
                new CalculadoraTest(3, 5),
                new CalculadoraTest(1, 2),
                new FacebookTest("Emiliano", "Gnocchi","emiliano@gmail.com", "emiliano@gmail.com", "seleenium"),
                new FacebookTest("Juan", "Perez","juan@gmail.com", "juan@gmail.com", "juan123"),
                new FacebookTest("Ana", "Vazquez","ana@gmail.com", "ana@gmail.com", "ana333")

        };
    }
}
