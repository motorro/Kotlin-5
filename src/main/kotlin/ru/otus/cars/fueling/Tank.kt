package ru.otus.cars.fueling

/**
 * Бензобак
 */
interface Tank {
    /**
     * Горловина бачка
     */
    val mouth: TankMouth

    /**
     * Получить кол-во залитых литров
     */
    fun getContents(): Int

    /**
     * Заправить несколько литров
     */
    fun receiveFuel(liters: Int)
}

/**
 * Рабочий бак
 */
class WorkingTank private constructor(): Tank {
    /**
     * Сборщик бака
     */
    companion object {
        /**
         * Создаёт бак
         */
        fun create(mouth: TankMouth.Builder): Tank = WorkingTank().apply {
            this.mouth = mouth.create(this)
        }
    }

    /**
     * Содержимое
     */
    private var contents: Int = 0

    /**
     * Горловина бачка
     */
    override lateinit var mouth: TankMouth
        private set

    /**
     * Получить кол-во залитых литров
     */
    override fun getContents(): Int = contents

    /**
     * Заправить несколько литров
     */
    override fun receiveFuel(liters: Int) {
        contents += liters
    }
}