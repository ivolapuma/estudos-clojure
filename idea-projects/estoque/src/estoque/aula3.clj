(ns estoque.aula3)

; PREDICATE
(defn aplica-desconto?
  [valor]
  (if (> valor 100)
    true
    false))

(println (aplica-desconto? 900))
(println (aplica-desconto? 90))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [percentual-desconto (/ 10 100)
          valor-desconto (* valor-bruto percentual-desconto)]
      (- valor-bruto valor-desconto))
    valor-bruto))

(println (valor-descontado 900))
(println (valor-descontado 90))

; redefinindo aplica-desconto
; a ligação na chamada da função ocorre em tempo de execução, por isso que a definição anterior
; tbm é chamada nas chamadas acima dessa definição
(defn aplica-desconto?
  [valor]
  (if (> valor 100)
    true))

(println (aplica-desconto? 900))
(println (aplica-desconto? 90))
(println (valor-descontado 900))
(println (valor-descontado 90))

; nova versao com forma when
(defn aplica-desconto?
  [valor]
  (when (> valor 100)
    true))

(println (valor-descontado 900))
(println (valor-descontado 90))

; nova versao direta
(defn aplica-desconto?
  [valor]
  (> valor 100))

(println (valor-descontado 900))
(println (valor-descontado 90))

(defn mais-caro-que-100?
  [valor]
  (println "mais-caro-que-100 chamado")
  (> valor 100))

; versao redefinida que recebe funcao como parametro
(defn valor-descontado
  "Retorna o valor com desconto de 10% se deve aplicar o desconto."
  [ aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [percentual-desconto (/ 10 100)
          valor-desconto (* valor-bruto percentual-desconto)]
      (- valor-bruto valor-desconto))
    valor-bruto))

(println "recebe funcao como parametro")
(println (valor-descontado mais-caro-que-100? 900))
(println (valor-descontado mais-caro-que-100? 90))

; HIGHER ORDER FUNCTIONS
; IMUTABILIDADE

(println "recebe funcao sem nome ou anonima (lambda)")
(println (valor-descontado (fn [valor] (> valor 100)) 900))
(println (valor-descontado (fn [valor] (> valor 100)) 90))
(println (valor-descontado (fn [v] (> v 100)) 900))
(println (valor-descontado (fn [v] (> v 100)) 90))
(println (valor-descontado #(> %1 100) 900))
(println (valor-descontado #(> %1 100) 90))
(println (valor-descontado #(> % 100) 900))
(println (valor-descontado #(> % 100) 90))

; quanto menos caracteres, mais simples, porem mais ambiguo (menos legivel)

; outra forma de definir uma funcao
(def mais-caro-que-100? #(> % 100))
(println "chamando simbolo definido como uma funcao lambda")
(println (valor-descontado mais-caro-que-100? 900))




