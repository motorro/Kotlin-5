package ru.otus.cars

import ru.otus.cars.fueling.TankMouth

/**
 * Машина целиком
 */
interface Car : CarInput {
    /**
     * Номерной знак
     */
    val plates: Plates

    /**
     * Цвет машины
     */
    val color: String

    /**
     * Следит за машиной
     */
    val carOutput: CarOutput

    /**
     * Получить оборудование
     */
    fun getEquipment(): String

    /**
     * Горловина бака
     */
    val tankMouth: TankMouth

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)
}