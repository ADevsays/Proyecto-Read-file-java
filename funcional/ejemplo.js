function createCounter(){
    let counter = 0;
    return ()=> ({
        addCounter: ()=> counter++,
        restCounter: ()=> counter--,
        showCounter: (number)=> console.log(`El counter ${number} es ${counter}`) 
    });
}

const counter1 = createCounter();
const counter2 = createCounter();
const counter3 = createCounter();

counter1().addCounter();
counter1().addCounter();
counter1().addCounter();
counter1().addCounter();
counter1().showCounter(1);

counter2().addCounter();
counter2().showCounter(2);


//closure