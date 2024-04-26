package ru.otus.cars.fueling

/**
 * Горловина бака
 */
sealed class TankMouth {
    /**
     * Создает бак
     */
    interface Builder {
        fun create(tank: Tank): TankMouth
    }

    /**
     * Бак, к которому приварили горловину
     */
    protected lateinit var tank: Tank

    /**
     * Крышка снята или нет
     */
    private var opened: Boolean = true

    /**
     * Открыть
     */
    fun open() {
        opened = true
    }

    /**
     * Закрыть
     */
    fun close() {
        opened = false
    }

    /**
     * Заполняем бак
     */
    protected fun putFuel(liters: Int) {
        if (opened) {
            tank.receiveFuel(liters)
        }
    }
}

/**
 * Горловина для бензина
 */
class PetrolMouth private constructor(): TankMouth() {
    companion object : Builder {
        override fun create(tank: Tank): TankMouth {
            return PetrolMouth().apply { this.tank = tank }
        }
    }

    /**
     * Для бензина
     */
    fun fuelPetrol(liters: Int) {
        putFuel(liters)
    }
}

/**
 * Горловина для газа
 */
class LpgMouth private constructor(): TankMouth() {
    companion object : Builder {
        override fun create(tank: Tank): TankMouth {
            return LpgMouth().apply { this.tank = tank }
        }
    }

    fun fuelLpg(liters: Int) {
        putFuel(liters)
    }
}
