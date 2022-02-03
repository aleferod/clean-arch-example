# clean-arch-example
Clean Arch example using Java 11, SpringBoot, Junit and Mockito

# Escopo de negócio 

Calcular alguns impostos (PIS e COFINS) com base na receita bruta

Aliquota PIS = 1,65%
Aliquota COFINS = 7,60%

Receber do usuario o CNPJ e a Receita Bruta e devolver: razao social, CNPJ, receita bruta, valor do PIS e valor do COFINS

Api para obter a razao social pelo CNPJ

get all -> https://61fad8a487801d0017a2c2ec.mockapi.io/razaosocial/

get by id (cnpj) -> https://61fad8a487801d0017a2c2ec.mockapi.io/razaosocial/{cnpj}

# Usando a app

- Importar a collection do postman (clean-arch-example.postman_collection.json)
- Passar na chamada o cnpj (consultar no endpoint get all do mockapi os CNPJs cadastrados) e a receita bruta
- Realizar a chamada e obter os valores dos impostos (PIS e COFINS) no corpo da resposta
