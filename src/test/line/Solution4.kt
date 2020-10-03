package line

class Problem5 {
    var INDEX = 0
    val BLACKJACK = 21
    val PLAYER = true
    val DEALER = false

    var playerHas = false
    var dealerHas = false

    var cards: IntArray = intArrayOf()

    fun solution(cards: IntArray): Int {
        this.cards = cards
        var playerCoin = 0

        loop@ while (cards.size > INDEX) {
            var dealerSum = 0
            var playerSum = 0
            playerHas = false
            dealerHas = false

            var showingDealerCard = 0
            var currentCard = 0

            //step 1.
            currentCard = getCard(PLAYER)
            if (currentCard == -1) break

            playerSum += currentCard
            //step 2.
            currentCard = getCard(DEALER)
            if (currentCard == -1) break

            dealerSum += currentCard
            //step 3.
            currentCard = getCard(PLAYER)
            if (currentCard == -1) break

            playerSum += currentCard
            //step 4.
            currentCard = getCard(DEALER)
            if (currentCard == -1) {
                break
            }
            showingDealerCard = currentCard
            dealerSum += currentCard

            if (getCardSum(playerSum, PLAYER, BLACKJACK) == BLACKJACK) {
                //5.1
                if (getCardSum(dealerSum, DEALER, BLACKJACK) != BLACKJACK) playerCoin += 3

            } else if (getCardSum(playerSum, PLAYER, BLACKJACK) < BLACKJACK) {
                //5.2
                when (showingDealerCard) {
                    2, 3 ->
                        while (getCardSum(playerSum, PLAYER, 12) < 12) {
                            currentCard = getCard(PLAYER)
                            if (currentCard == -1) {
                                break@loop
                            }
                            playerSum += currentCard
                        }
                    4, 5, 6 -> {
                    }
                    else ->
                        while (getCardSum(playerSum, PLAYER, 17) < 17) {
                            currentCard = getCard(PLAYER)
                            if (currentCard == -1) break@loop

                            playerSum += currentCard
                        }
                }
                //step 6.
                while (getCardSum(dealerSum, DEALER, 17) < 17) {
                    currentCard = getCard(DEALER)
                    if (currentCard == -1) {
                        break@loop
                    }
                    dealerSum += currentCard
                }
                if (getCardSum(dealerSum, DEALER, BLACKJACK) > BLACKJACK) {
                    playerCoin += 2
                } else {
                    if (getCardSum(playerSum, PLAYER, BLACKJACK) == getCardSum(dealerSum, DEALER, BLACKJACK)) {
                    } else if (getCardSum(playerSum, PLAYER, BLACKJACK) > getCardSum(dealerSum, DEALER, BLACKJACK)) {
                        playerCoin += 2
                    } else {
                        playerCoin -= 2
                    }
                }
            } else playerCoin -= 2
        }

        return playerCoin
    }

    fun getCard(isUser: Boolean): Int {
        if (cards.size <= INDEX) return -1

        var card = cards[INDEX]
        when (card) {
            11, 12, 13 -> card = 10
            1 -> if (isUser)
                playerHas = true
            else
                dealerHas = true
        }
        INDEX++
        return card
    }

    fun getCardSum(sum: Int, isValid: Boolean, goalScore: Int): Int {

        val hasCardA = if (isValid) playerHas else dealerHas
        if (hasCardA) {
            val sum11 = sum + 10
            if (sum11 <= goalScore || sum11 == BLACKJACK) return sum11
        }
        return sum
    }
}

fun main() {
    val test = Problem5().solution(intArrayOf(12, 7, 11, 6, 2, 12))
    val test1 = Problem5().solution(intArrayOf(1, 4, 10, 6, 9, 1, 8, 13))
    val test2 = Problem5().solution(intArrayOf(10, 13, 10, 1, 2, 3, 4, 5, 6, 2))
    val test3 = Problem5().solution(intArrayOf(3, 3, 3, 3, 3, 3, 3, 3, 3, 3))

    println(test.toString())
    println(test1.toString())
    println(test2.toString())
    println(test3.toString())
}