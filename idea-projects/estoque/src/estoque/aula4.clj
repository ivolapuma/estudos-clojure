(ns estoque.aula4)

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 0))
(println (get precos 2))
;(println (precos 3))                                        ; vai dar erro
(println (get precos 3))                                    ; nao vai dar erro, get tem tratamento
(println "get com valor padrao nil:" (get precos 3))
(println "get com valor padrao 0:" (get precos 3 0))
(println "get com valor padrao 0, mas posicao existe:" (get precos 2 0))

(println (conj precos 5))
(println precos)

; funcao para incremento (inc)
(println (+ 5 1))
(println (inc 5))
; funcao para decremento (dec)
(println (- 10 1))
(println (dec 10))

; funcao para atualizar array
(println (update precos 0 inc))
(println (update precos 1 dec))
(println precos)

;(update precos 0 1) ; nao compila pq update vai pedir uma IFn como parametro
(update precos 0 #(+ % 1))                                  ; passando uma lambda para atualizar o elemento da colecao
; ou
(defn soma-1 [valor] (+ valor 1))
(update precos 0 soma-1)
(println precos)

;;;
; exemplo funcao map
;;;

(defn aplica-desconto?
  [valor]
  (> valor 100))

(defn valor-descontado
  [valor]
  (if (aplica-desconto? valor)
    (let [taxa (/ 10 100)
          desconto (* valor taxa)]
      (- valor desconto))
    valor))

(println (valor-descontado 100))
(println (valor-descontado 1000))

(println "precos" precos)
(println "map" (map valor-descontado precos))

; teste com lambda e map
;(defn valor-descontado
;  [aplica? valor]
;  (if (aplica? valor)
;    (let [taxa (/ 10 100)
;          desconto (* valor taxa)]
;      (- valor desconto))
;    valor))
;
;(println (valor-descontado #(> % 100) 1000))
;(println (valor-descontado #(> % 100) 100))

; (println (map valor-descontado #(> % 100) precos))          ; isso nao compila

;;;
; exemplo funcao filter
;;;

(println (range 10))                                        ; funcao range retorna uma lista de 0 a %1
(println (filter even? (range 10)))                         ; deve imprimir os numeros pares de range 10

(println "vetor" precos)
(println "filter" (filter aplica-desconto? precos))
(println "map apos filter" (map valor-descontado (filter aplica-desconto? precos)))

;;;
; exemplo funcao reduce
;;;

(println "precos" precos)
(println "soma dos precos" (reduce + precos))

; outra forma de somar para ver como o reduce age

(defn minha-soma
  [v1 v2]
  (println "somando" v1 v2)
  (+ v1 v2))

(println "precos" precos)
(println "minha-soma dos precos" (reduce minha-soma precos))
(println "minha-soma dos precos" (reduce minha-soma (range 10)))
(println "minha-soma dos precos" (reduce minha-soma [100]))

(println "minha-soma dos precos" (reduce minha-soma 0 precos))

(println (reduce minha-soma 0 [100]))
(println (reduce minha-soma 0 []))
;(println (reduce minha-soma []))                            ; erro de execucao: numero errado de parametros

;(println (minha-soma (range 2) (range 10)))                 ; erro de execucao: LongRange nao pode ser convertido para Number



