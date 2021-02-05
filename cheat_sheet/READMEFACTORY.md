<a name='top'></a>
[Principal](../README.md)

# Factory:
Una fábrica sirve para crear muchas instancias de una clase, pudiendo pasar en cada una de ellas parametros

**Ejemplo**

    @Factory
    public Object[] facebookFactoryTest(){
        return new Object[]{
            new FacebookTest(),
            new FacebookTest(),
            new FacebookTest(),
        };
    }

Nota: cuando ejecutemos la fábrica se ejecurá tres veces los test de la clase FacebookTest.</br>

con paso de parámetros al constructor de la clase:

    @Factory
    public Object[] facebookFactoryTest(){
        return new Object[]{
            new FacebookTest(param: 3),
            new FacebookTest(param: 2),
            new FacebookTest(param: 1),
        };
    }

La clase de test, tendrá unc constructor que reciba ese parámetro y lo setee a una variable de clase.

    private WebDriver driver;
    private int parametro=0;
    
    public FacebookTest(parameter){
        this.parametro=parameter;
    }

[Subir](#top)