<a name='top'></a>
[Principal](../README.md)

# Localizadores Selenium:
# función 'by' en Selenium
'By' nos permite localizar elementos utilizando algunas de las carcaterísticasx del mismo.

### Posibles formas de localizar elementos:
* Id
* Name
* Class Name
* Tag Name
* Link Text
* Partial Link text

**Ejemplos:**

        (By Id)
        <div id='myDomainId'>mi dominio</div>
        driver.findElement(by.id('myDomainId)).click();

        (By Name)
        <input name='myDomainId'>enter domain name</input>
        driver.findElement(By.tagName('input'));

        (By tagName)
        <input name='myDomainId'>enter domain name</input>
        driver.findElement(By.name('myDomainName')).send_keys('test');

        (linkText)
        <a href='/legal/update' id='terms'>Condiciones de uso</a>
        driver.findElement(By.linkText('myDomainLinkText')).click();

        (patialLinkText)
        <a href='/legal/update' id='terms'>Condiciones de uso</a>
        driver.findElement(By.partialLinktext('Condiciones de')).click();

### RadioButton:
**By.Id:**

    driver.findElement(By.id('Male')).click();

![graph](images/Radio.png)

### DropDown:
![graph](images/select-value.png)

**selectByValue()**

![graph](images/select-value-0.png)

    WebElement element = driver.findElement(By.id('month'));
    Select month = new Select(element);
    month.selectByValue('0');

**selectByIndex()**

![graph](images/selectByIndex.png)

    WebElement element = driver.findElement(By.id('days'));
    Select days = new Select(element);
    days.selectByindex(5);

**selectByVisibleText()**

![graph](images/selectByVisibleText.png)

    WebElement element = driver.findElement(By.id('month'));
    Select month = new Select(element);
    month.selectByVisibleText('Mar');

### findElements:
devuelve una lista con todos los elementos encontrados, pudiendo posicionarnos en el elemento deseaso por la posicion que ocupa en la lista

        (tag Name)
        <p class='mydomainh3'>un<p>
        <p class='mydomainh3'>dos<p>
        <p class='mydomainh3'>tres<p>
        elementos = driver.findElements(By.tagName('p'));
        for p in elementos:
            print(p.text)

## ASSERT:
Valida el resultado obtenido con el esperado. Si el resultado obtenido y el esperado con iguales será un resultado de exito si no sera un error y terminará el test

* **assertArrayEquals**	------ Sirve para comparar dos arreglos y afirmar distintas propiedades del mismo.
* **assertEquals** ----------- Sirve para comparar dos tipos de datos u objetos y afirmar que son iguales.
* **assertFalse** ------------ Sirve para afirmar que un tipo de dato u objeto es falso.
* **assertNotNull**	---------- Sirve para afirmar que un tipo de dato u objeto no es nulo.
* **assertNotSame**	---------- Sirve para comparar dos tipos de datos y afirmar que son distintos.
* **assertNull** ------------- Sirve para afirmar que un tipo de dato u objeto es nulo.
* **assertThat** ------------- Sirve para comparar un tipo de dato u objeto. A diferencia de los assertions normales este trabaja con Matcher
* **assertTrue** ------------- Sirve para afirmar que un tipo de dato u objeto es verdadero.

        Assert.asserttEquals(valor_obtenido, valor_experado)

[Subir](#top)