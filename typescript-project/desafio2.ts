// Como podemos melhorar o esse código usando TS? 
/*
let pessoa1 = {};
pessoa1.nome = "maria";
pessoa1.idade = 29;
pessoa1.profissao = "atriz"

let pessoa2 = {}
pessoa2.nome = "roberto";
pessoa2.idade = 19;
pessoa2.profissao = "Padeiro";

let pessoa3 = {
    nome: "laura",
    idade: "32",
    profissao: "Atriz"
};

let pessoa4 = {
    nome = "carlos",
    idade = 19,
    profissao = "padeiro"
}
*/



enum Profissao {
    Atriz,
    Padeiro,
}

//SOLUÇÃO 1 ABAIXO

interface Pessoa {
    nome: string,
    idade: number,
    profissao: Profissao
}

let pessoa1: Pessoa = {
    nome: "Maria",
    idade: 29,
    profissao: Profissao.Atriz
};

let pessoa2: Pessoa = {
    nome: "Roberto",
    idade: 29,
    profissao: Profissao.Padeiro
};

let pessoa3: Pessoa = {
    nome: "Laura",
    idade: 29,
    profissao: Profissao.Atriz
};

let pessoa4: Pessoa = {
    nome: "Carlos",
    idade: 29,
    profissao: Profissao.Padeiro
};

console.log(pessoa1);
console.log(pessoa2);
console.log(pessoa3);
console.log(pessoa4);

//SOLUÇÃO 2 ABAIXO
class Person {
    private nome: string;
    private idade: number;
    private profissao: Profissao;

    constructor(nome: string, idade: number, profissao: Profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }
}

function createPerson(nome: string, idade: number, profissao: Profissao) {
    console.log(new Person(nome, idade, profissao));
}

const people = [
    {
        nome: "Maria",
        idade: 29,
        profissao: Profissao.Atriz
    },
    {
        nome: "Roberto",
        idade: 19,
        profissao: Profissao.Padeiro  
    },
    {
        nome: "Laura",
        idade: 32,
        profissao: Profissao.Atriz  
    },
    {
        nome: "Carlos",
        idade: 29,
        profissao: Profissao.Padeiro 
    },
];

people.forEach(person => {
    createPerson(person.nome, person.idade, person.profissao);
})
