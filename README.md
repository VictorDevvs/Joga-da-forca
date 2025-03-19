### 📜 README.md

```markdown
# Jogo da Forca 🪢

Este é um jogo da forca simples desenvolvido em Java. O jogo escolhe uma palavra aleatória de um dicionário e o jogador deve adivinhar as letras antes de esgotar suas chances.

## 🛠️ Tecnologias utilizadas

- Java 17+ (recomendado)
- Paradigma de Programação: Orientado a Objetos
- Entrada/Saída via console
- Manipulação de arquivos para carregar palavras do dicionário

## 📌 Como jogar?

1. O jogo exibe um espaço para cada letra da palavra oculta.
2. O jogador deve inserir uma letra por vez.
3. Se a letra estiver na palavra, ela será revelada.
4. Se errar, perderá uma chance. O jogador tem **5 chances** no total.
5. O jogo termina quando todas as letras forem descobertas ou quando as chances se esgotarem.
6. Após cada rodada, o jogador pode optar por jogar novamente ou sair.

## 🚀 Como executar o projeto?

### Requisitos:
- Java JDK 17 ou superior instalado
- IDE compatível (Eclipse, IntelliJ, VS Code) ou terminal

### Passos:
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/jogo-da-forca.git
   ```
2. Compile os arquivos Java:
   ```sh
   javac -d bin src/hangman/**/*.java
   ```
3. Execute o jogo:
   ```sh
   java -cp bin hangman.core.Game
   ```

## 📂 Estrutura do projeto

```
JogoDaForca/
│── src/
│   ├── hangman/
│   │   ├── core/           # Lógica principal do jogo
│   │   │   ├── Game.java   # Classe principal que gerencia o jogo
│   │   │   ├── Word.java   # Representa a palavra oculta
│   │   │   ├── Dictionary.java # Gerencia a escolha de palavras do dicionário
│   │   │   ├── InvalidLetterException.java # Exceção para entradas inválidas
│   │   ├── io/             # Entrada e saída do jogo
│   │   │   ├── Input.java  # Lida com entrada do usuário e arquivos
│   │   │   ├── Output.java # Exibe mensagens no console
│   ├── resources/
│   │   ├── dictionary.txt  # Arquivo contendo as palavras usadas no jogo
│── README.md               # Documentação do projeto
│── .gitignore              # Arquivos ignorados no versionamento
```

## ⚠️ Possíveis erros e soluções

- **Erro**: `File not found: /hangman/resources/dictionary.txt`
  - Certifique-se de que o arquivo `dictionary.txt` está no local correto.

- **Erro**: `Only letters are allowed`
  - O jogo não aceita números ou símbolos, apenas letras.

## 📜 Licença

Este projeto é de código aberto e pode ser modificado e distribuído livremente.

---

🎮 Divirta-se jogando o **Jogo da Forca**! 🚀
```

Se precisar de ajustes ou quiser adicionar mais informações, me avise! 😊
