
// Como podemos rodar isso em um arquivo .ts sem causar erros? 
/*
let employee = {};
employee.code = 10;
employee.name = "John";
*/

function exibeDados (employee: {code: number, name: string}): void {
    console.log(`Nome do funcionário: ${employee.name} | Código: ${employee.code}`);
}

interface Employee {
    code: number,
    name: string
};

const employee1: Employee = {
    code: 10,
    name: "Maria"
};

exibeDados(employee1);

const employee2 : {code: number, name: string} = {
    code: 22,
    name: "Luiza"
}

exibeDados(employee2);

const employee3 = {
    code: 38,
    name: "Hugo"
}

exibeDados(employee3);