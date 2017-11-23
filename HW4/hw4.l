;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Your solution goes in this file ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;; all-length(l) ::::::::::::::::::::::::::
(defun all-length(l)
	(cond 
		((null l) 0)

		((listp (car l)) 
			(+ (all-length(car l)) (all-length(cdr l))))
		
		(t (+ (all-length(cdr l)) 1))
	)
)

;;;;;;;;;;;;;;;;;;;;;;;;; Range(l) ::::::::::::::::::::::::::
(defun min_list(l)
	(cond 
		((= 1 (length l)) (car l)) ;if, return list 

		(t 						   ; else
			(setq mi (min_list (cdr l)))		   ; call min on the rest of the list
			
			(cond 
				((> mi (car l)) (car l)) ;if the 
				(t mi)	
			)
		)
	)
)


(defun max_list(l)
	(cond 
		((= 1 (length l)) (car l)) ;if, return list 

		(t 						   ; else
			(setq ma (max_list (cdr l)))		   ; call max on the rest of the list
			
			(cond 
				((> ma (car l)) ma)
				(t (car l))
			)
		)
	)
)

(defun range(l)
	(list (min_list l) (max_list l))
)

;;;;;;;;;;;;;;;;;;;;;;;;; Before(l) ::::::::::::::::::::::::::
;; searches a list and returns a list of 
;; all elements in between the first two
;; arguments (inclusive).
(defun before(start end l)
	(cond 
		((null l) ())

		;; found the start in the list
		((equal start (car l)) 
			(setq x (beforeHelp start end l))

			;; beforeHelp return null, then we did not found end
			;; ohterwise, return the list returned by beforeHelp
			(cond 
				((null x) ())
				(t x)
			)
		)
		
		(t (before start end (cdr l)))	
	)

)

(defun beforeHelp(start end l)
	(cond 
		;; if end is not in the list return empty list
		((null l) ())
		;; found the end in the list if not return empty list
		((equal end (car l)) (list (car l)))
		;; else recurse down
		(t (cons (car l) (beforeHelp start end (cdr l)) ))
	)
)

;;;;;;;;;;;;;;;;;;;;;;;;; Split-If ;;::::::::::::::::::::::::::
(defun split-left (func l)
	(cond
		((null l) nil)
		((equal nil (funcall func (car l)))
			(append (list (car l)) (split-left func (cdr l))))
		(t  (split-left func (cdr l)))
	)
)

(defun split-right (func l)
	(cond
		((null l) nil)
		((equal t (funcall func (car l)))
			(append (list (car l)) (split-right func (cdr l))))
		(t  (split-right func (cdr l)))
	)
)

(defun split-if (func l)
	(list (split-left func l) (split-right func l))
)

;;;;;;;;;;;;;;;;;;;;;;;;; Group ;;::::::::::::::::::::::::::
(defun group(l n)
	(group-help l n nil)
)

(defun group-help(l n temp)
	(cond
		;; if both l and temp are null, it means we reached the end
		((and (null l) (null temp)) nil)

		((null l) (list temp))

		((< (length temp) n) 
			(group-help (cdr l) n (append temp (list (car l)))))

		((equal (length temp) n) 
			(cons temp (group-help l n nil)))
	)
)

;;;;;;;;;;;;;;;;;;;;;;;;; Mostn ;;::::::::::::::::::::::::::
(defun mostn (func l)
	(setq value (funcall func (car l)))
	(setq ma (get-max func l value))
	(cons (get-list func l ma) (list ma))
)

(defun get-max (func l value)
	(cond
		;;when reach end simply return value
		((null l) value)
		;;when value < value of first item, reset value 
		((< value (funcall func (car l)))
			(setq value (funcall func (car l)))
			(get-max func (cdr l) value)
		)

		(t (get-max func (cdr l) value))
	)
)

(defun get-list (func l ma)
	(cond
		((null l) nil)

		((= ma (funcall func (car l)))
			(cons (car l) (get-list func (cdr l) ma))
		)

		(t (get-list func (cdr l) ma))
	)
)

;;;;;;;;;;;;;;;;;;;;;;;;; match ;;::::::::::::::::::::::::::
(defun match (l1 l2)
	(cond
		;; if l1 and l2 are exactly the same return true
		((equal l1 l2)  t) 

		;; if both are null (reach the end) return true
		;; if only one of them is null return false
		((and (null l1) (null l2))  t) 
		((and (null l1) (not (null l2))) nil)
		((and (not (null l1)) (null l2)) nil)
		
		;; ? only matches one item
		( (equal '? (car l1))
			(match (cdr l1)(cdr l2)) )
		
		;; if we found ! in l1 try to see if the next element matches
		;; if not go to next statement
		( (and
			(equal '! (car l1)) 
			(match (cdr l1)(cdr l2))) 
			T ;;return true 
		)
		
		;; if the next atom in l1 and l2 does not match
		;; stay at ! sign and advance l2 until it matches
		;; with the next atom of l1
		( (equal '! (car l1)) 	(match l1 (cdr l2)) )

		;; if the first atom of l1 and l2 matches, then advance both
		( t	(and (equal (car l1) (car l2)) (match (cdr l1) (cdr l2)) ))
	)
)


;;;;;;;;;;;;;;;;;;;;;;;;; match variable ;;::::::::::::::::::::::::::
(defun match-var (l1 l2)
	(cond
		;; if l1 and l2 are exactly the same return true
		((equal l1 l2)  t)

		;; if both are null (reach the end) return true
		;; if only one of them is null return false
		((and (null l1) (null l2))  t)
		((and (null l1) (not (null l2))) nil)
		((and (not (null l1)) (null l2)) nil)
				
		((listp (car l1))
			(cond
				
				((equal '? (caar l1))
					(setq result (match-var (cdr l1) (cdr l2)))
					;; if match-var returns true here
					(cond
						(result 
							(set (cadar l1) (car l2)) 
							result);; return true
						(t result) ;; else return false
					)

				)
				;; if next atom of l1 after ! and next atom of l2 matches
				;; set thr variable and return true
				( 	(and
						(equal '! (caar l1))
						(match-var (cdr l1) (cdr l2))) 
					
					(set (cadar l1) (list (car l2))) 
					
					t ;; return true
				)
				

				(   (equal '! (caar l1))
					(setq result (match-var l1 (cdr l2)))
					
					(cond
						(result
							(set (cadar l1) (cons (car l2) (eval (cadar l1)) ))
							result)
						(t result)
					)
				)
			
				(t  (and (equal (car l1) (car l2)) (match-var (cdr l1) (cdr l2)) ))
			)
		)

		( t	(and (equal (car l1) (car l2)) (match-var (cdr l1) (cdr l2)) ))
	)
)
