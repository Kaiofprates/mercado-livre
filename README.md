## Desafio Mercado Livre - Orange Talents ( versão em Kotlin e Micronaut)


### Endpoints
> [cadastro de produto] - requer autenticação básica com usuário(email) e senha
``` bash
curl --request POST \
  --url http://localhost:8080/api/produtos \
  --header 'Authorization: Basic dGVzdGVAaG90bWFpbC5jb206c2VuaGExMjM0NQ==' \
  --header 'Content-Type: application/json' \
  --cookie JSESSIONID=59CFC4CB8BDFE91EC57EBC4CBAAE58AC \
  --data '{
	"nome" : "Celular",
	"valor" : 2500,
	"quantidade" : 5,
	"descricao" : "Celular seminovo, caiu no vaso só 2 vezes",
	"categoria" : 1,
	"caracteristica" :[
		{
			"marca" : "sansung",
			"modelo" : "A10",
			"unidades" : 2
		},
		{
			"marca" : "motorola",
			"modelo" : "moto g",
			"unidades" : 4
		},
		{
			"marca" : "Apple",
			"modelo" : "iphone 9",
			"unidades" : 2
		}
	]
}'

```
> [cadastro de usuário] 
```bash
curl --request POST \
  --url http://localhost:8080/api/usuarios \
  --header 'Content-Type: application/json' \
  --data '{
	"email" : "johndoe@gmail.com.br",
	"password" : "senha1234"
}'
```
>[cadastro de categorias]
```bash
curl --request POST \
  --url http://localhost:8080/api/categorias \
  --header 'Authorization: Basic dGVzdGVAaG90bWFpbC5jb206c2VuaGExMjM0NQ==' \
  --header 'Content-Type: application/json' \
  --cookie JSESSIONID=59CFC4CB8BDFE91EC57EBC4CBAAE58AC \
  --data '{
	"nome" : "Eletrônicos"
}'
```
```bash

curl --request POST \
  --url http://localhost:8080/api/categorias \
  --header 'Authorization: Basic dGVzdGVAaG90bWFpbC5jb206c2VuaGExMjM0NQ==' \
  --header 'Content-Type: application/json' \
  --cookie JSESSIONID=59CFC4CB8BDFE91EC57EBC4CBAAE58AC \
  --data '{
	"nome" : "Celular",
	"categoriaId": 1
}'
```