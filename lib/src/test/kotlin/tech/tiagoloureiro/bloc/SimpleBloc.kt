package tech.tiagoloureiro.bloc

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import tech.tiagoloureiro.bloc.Bloc

internal class SimpleBloc(scope: CoroutineScope) :
    Bloc<SimpleBlocState, SimpleBlocEvent>(FirstState, scope) {
    override suspend fun mapEventToState(
        event: SimpleBlocEvent,
        state: SimpleBlocState,
        emit: suspend (state: SimpleBlocState) -> Unit
    ) {
        when (event) {
            is ChangeState -> {
                when (event.stateNumber) {
                    1 -> {
                        emit(FirstState)
                    }
                    2 -> {
                        emit(SecondState)
                    }
                    3 -> {
                        emit(ThirdState)
                    }
                    4 -> {
                        emit(FourthState)
                    }
                    5 -> {
                        emit(FifthState)
                    }
                    else -> {
                        delay(500)
                        emit(UnknownState)
                        delay(500)
                        emit(EndState)
                    }
                }
            }
        }
    }
}

/*
 * SimpleBlocStates
 *
 */
sealed class SimpleBlocState

object FirstState : SimpleBlocState()

object SecondState : SimpleBlocState()

object ThirdState : SimpleBlocState()

object FourthState : SimpleBlocState()

object FifthState : SimpleBlocState()

object UnknownState : SimpleBlocState()

object EndState : SimpleBlocState()

/*
 * SimpleBlocEvents
 *
 */
sealed class SimpleBlocEvent

data class ChangeState(val stateNumber: Int) : SimpleBlocEvent()
