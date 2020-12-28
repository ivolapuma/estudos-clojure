(ns estoque.exemplos-aula)

; exemplos de funcoes

; []   // simbolo para definir uma lista (vetor)
; ()   // simbolo para invocar uma funcao (1o elemento é o nome da funcao)
; 10   // Long
; 10.0 // Double
; 10N  // BigInt
; 10M  // BigDecimal

(println "ola clojure")                                     ; println imprime na tela
(count [1 2 3])                                             ; count conta quantidade de elementos
(conj ["A" "B"] "C")                                        ; conj inclui um elemento e devolve uma outra lista com todos os elementos
(class 90N)                                                 ; class retorna qual a classe do elemento)

(def simbolo 10)                                            ; def define valor de simbolo
(defn f [x] (* 2 x))                                        ; defn define uma funcao

; // 01 simbolos locais versus globais

(defn imprime-mensagem []
  (println "---------------------")
  (println "Bem-vind@ ao estoque!"))

(defn aplica-desconto [valor-bruto]
  (* valor-bruto 0.9))

(defn valor-descontado 
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (* valor-bruto (- 1 0.1))
)

(defn valor-descontado 
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (def desconto 0.1)
  (* valor-bruto (- 1 desconto))
)

(defn valor-descontado 
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [desconto 0.1]
    (println "Calculando desconto de" desconto)
    (* valor-bruto (- 1 desconto)))
)

(defn valor-descontado 
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [desconto (/ 10 100)]
    (println "Calculando desconto de" desconto)
    (* valor-bruto (- 1 desconto)))
)

; // 02 let multiplo e condicionais

(defn valor-descontado 
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (let [percentual-desconto (/ 10 100)
        valor-desconto      (* valor-bruto percentual-desconto)]
    (println "Calculando desconto de" valor-desconto)
    (- valor-bruto valor-desconto))
)

; assim como operacoes sao funcoes:
(+ 10 20)
(/ 300 10)

; comparacaoes tbm sao:

(> 500 100)
(= 10 10)

; condicionais:

(if (> 500 100)
  (println "maior")
  (println "menor ou igual"))

(if (> 50 100)
  (println "maior")
  (println "menor ou igual"))

(defn valor-descontado 
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [percentual-desconto (/ 10 100)
          valor-desconto      (* valor-bruto percentual-desconto)]
      (println "Calculando desconto de" valor-desconto)
      (- valor-bruto valor-desconto))
    valor-bruto
  )
)

; // BigInt e BigDecimal

; Em algumas linguagens, ao somar 1 ao maior número de Long, ocorre erro de estouro (ou ao diminuir 1 ao menor número de Long).
; No Clojure, se o tipo do dado é Long ou Double, ao somar/diminuir a valores limites do tipo, ele é automaticamente passado para BigInt e BigDecimal.

; // if

; Em Clojure, if é uma forma especial, não é uma funcao.
; Formas especiais formam a base mínima da linguagem.
; Podem ser usadas em nosso codigo e se misturam com as funcoes que invocamos em varios momentos.

; // nil

(if nil true false)
; => false

(if (= nil false) true false)
; => false

(if (= nil nil) true false)
; => true

(if 0 true false)
; => true
