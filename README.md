# ProjectInterfaceCar
Projeto usando várias camadas de serviço em java 15 sem usar interfaces na parte 1 e 2.
O objetivo do projeto é criar uma fatura para uma empresa de alugar carros, sem usar interface, demonstrando posteriormente que o projeto pode ser melhorado com o uso de 
interface, já que o serviço que calcula o imposto, com o uso de interface, pode centralizar mudanças no código caso seja necessário mudar o cálculo do imposto. Assim, 
existe um acoplamento forte sem o uso de interface, o que é indesejado (se a classe concreta BrazilTaxService mudar, é preciso mudar a classe RentalService) pois dificulta
a manutenção.
