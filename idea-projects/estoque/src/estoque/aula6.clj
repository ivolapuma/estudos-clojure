(ns estoque.aula6)


(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" (class valor) valor)
  15)

(println (map imprime-e-15 pedido))

;(defn imprime-e-15 [chave valor]
;  (println chave "<e>" valor)
;  15)

(println (map imprime-e-15 pedido))

(defn imprime-e-15 [[chave valor]]
  (println chave "<e>" valor)
  15)

(println (map imprime-e-15 pedido))


(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))

;;; THREAD FIRST (simbolo ->)
;;; THREAD LAST  (simbolo ->>)

; funcao total-do-pedido com thread last
(defn total-do-pedido
  [pedido]
  (->> pedido
       (map preco-dos-produtos ,,,)
       (reduce + ,,,)))

(println (total-do-pedido pedido))


(defn preco-total-do-produto
  [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(println (total-do-pedido pedido))



(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (filter gratuito? (vals pedido)))

; versao de gratuito? com destruct
(defn gratuito?
  [[_ item]]                                                ; entre colchetes o map "destructed"
  (<= (get item :preco 0) 0))

(println (filter gratuito? pedido))

; versao com lambda
(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (filter (fn [[chave item]] (gratuito? item)) pedido))
(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

; composicao de funcoes
(println ((comp not gratuito?) {:preco 50}))

(def pago? (comp not gratuito?))                            ; comp retorna uma funcao
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))


;;;
; exercicio de map reduce
;;;

(def clientes [{:nome "Guilherme" :certificados ["Clojure" "Java" "ML"]}
               {:nome "Paulo" :certificados ["Java" "CS"]}
               {:nome "Daniela" :certificados ["Arquitetura" "Gastronomia"]}])

(println clientes)
(println (map :certificados clientes))
(println (map count (map :certificados clientes)))
(println (reduce + (map count (map :certificados clientes))))

(println (->> clientes (map :certificados) (map count) (reduce +)))

