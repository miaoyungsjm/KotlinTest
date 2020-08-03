package com.example.c4_coi.innerOrStatic

/**
 * @author ggz
 * @date 2020/7/29
 */
interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}