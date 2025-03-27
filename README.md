# 📱 Aplicativo "Álcool ou Gasolina?" - Guia Completo

## 🔍 Visão Geral
O Álcool ou Gasolina? é um aplicativo Android desenvolvido para ajudar motoristas a tomar a decisão mais econômica na hora de abastecer seu veículo. Com base nos preços dos combustíveis e no consumo do carro, o app calcula matematicamente qual opção oferece melhor custo-benefício.

## ✨ Recursos Principais
✅ Cálculo preciso da melhor opção de combustível <br>
✅ Interface intuitiva em 3 passos simples<br>
✅ Validação de dados para evitar erros<br>
✅ Persistência de dados durante rotação de tela<br>
✅ Design limpo e fácil de usar<br>

## 🛠️ Tecnologias Utilizadas
- Java para lógica de programação
- XML para interface do usuário
- Activities e Intents para navegação
- SavedInstanceState para persistência temporária de dados
- Toast para feedback ao usuário

## 🎨 Arquitetura dos Layouts
### 1. Tela Inicial (activity_main.xml)
Tipo de Layout: LinearLayout (Vertical)<br>
Objetivo: Inserção dos preços dos combustíveis<br>
Por que LinearLayout?<br>
✓ Fluxo linear intuitivo (preencha um campo após o outro)<br>
✓ Fácil alinhamento vertical<br>
✓ Ideal para formulários simples<br>

### 2. Tela de Consumo (activity_page2.xml)
Tipo de Layout: TableLayout<br>
Objetivo: Inserir o consumo do veículo<br>
Vantagens do TableLayout:<br>
✓ Organização tabular clara<br>
✓ Alinhamento automático entre campos<br>
✓ Facilita adição de novas linhas de dados<br>

### 3. Tela de Resultados (activity_page3.xml)
Tipo de Layout: ConstraintLayout dentro de ScrollView<br>
Objetivo: Exibir comparação detalhada<br>
Por que ConstraintLayout?<br>
✓ Posicionamento flexível dos elementos<br>
✓ Adaptável a diferentes tamanhos de tela<br>

OBS: Todos os layouts preservam o estado durante rotação de tela usando onSaveInstanceState()

## 📥 Instalação e Uso
### Requisitos:
- Dispositivo Android 5.0 (API 21) ou superior
- 10MB de espaço livre

### Como instalar:
git clone https://github.com/seu-usuario/alcool-ou-gasolina.git <br>
- Abra o projeto no Android Studio
- Conecte seu dispositivo ou use um emulador
- Clique em "Run"

### Como usar:
- Siga o fluxo natural do aplicativo
- Insira valores reais para obter resultados precisos
- Toque nos botões "ENVIAR" para validar cada informação

### 🤝 Como Contribuir
1. Faça um fork do projeto
2. Crie uma branch para sua feature (git checkout -b feature/incrivel)
3. Commit suas mudanças (git commit -m 'Adiciona feature')
4. Push para a branch (git push origin feature/incrivel)
5. Abra um Pull Request

### 📄 Licença
Este projeto está licenciado sob a Licença MIT <br>

Desenvolvido com ❤️ por Marina Villaça 
