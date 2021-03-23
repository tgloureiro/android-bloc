package tech.tiagoloureiro.bloc

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tech.tiagoloureiro.bloc.util.MainCoroutineRule

@ExperimentalCoroutinesApi
internal class BlocTest {

    @ExperimentalCoroutinesApi @get:Rule var mainCoroutineRule = MainCoroutineRule()

    private lateinit var simpleBloc: SimpleBloc

    @Before
    fun setup() {
        simpleBloc = SimpleBloc(CoroutineScope(Dispatchers.Main))
    }

    @Test
    fun simpleBloc_correctInitialState() = runBlockingTest {
        // When tasks are requested from the tasks repository
        val state = simpleBloc.state.value

        // Then tasks are loaded from the remote data source
        assertThat(FirstState, IsEqual(state))
    }

    @Test
    fun simpleBloc_shouldMapMultipleEventsToCorrectStates() = runBlockingTest {

        // Pause dispatcher so you can verify initial values.
        mainCoroutineRule.pauseDispatcher()
        simpleBloc.add(ChangeState(2))
        assertThat(simpleBloc.state.value, IsEqual(FirstState))

        mainCoroutineRule.resumeDispatcher()
        assertThat(simpleBloc.state.value, IsEqual(SecondState))

        mainCoroutineRule.pauseDispatcher()
        simpleBloc.add(ChangeState(3))
        assertThat(simpleBloc.state.value, IsEqual(SecondState))

        mainCoroutineRule.resumeDispatcher()
        assertThat(simpleBloc.state.value, IsEqual(ThirdState))

        mainCoroutineRule.pauseDispatcher()
        simpleBloc.add(ChangeState(4))
        assertThat(simpleBloc.state.value, IsEqual(ThirdState))

        mainCoroutineRule.resumeDispatcher()
        assertThat(simpleBloc.state.value, IsEqual(FourthState))

        mainCoroutineRule.pauseDispatcher()
        simpleBloc.add(ChangeState(5))
        assertThat(simpleBloc.state.value, IsEqual(FourthState))

        mainCoroutineRule.resumeDispatcher()
        assertThat(simpleBloc.state.value, IsEqual(FifthState))

        mainCoroutineRule.pauseDispatcher()
        simpleBloc.add(ChangeState(5))
        simpleBloc.add(ChangeState(4))
        simpleBloc.add(ChangeState(3))
        simpleBloc.add(ChangeState(2))
        simpleBloc.add(ChangeState(1))
        mainCoroutineRule.resumeDispatcher()
        assertThat(simpleBloc.state.value, IsEqual(FirstState))
    }

    @Test
    fun simpleBloc_shouldEmitMultipleStates() = runBlockingTest {
        assertThat(simpleBloc.state.value, IsEqual(FirstState))
        mainCoroutineRule.pauseDispatcher()
        simpleBloc.add(ChangeState(6))
        mainCoroutineRule.advanceTimeBy(600)
        assertThat(simpleBloc.state.value, IsEqual(UnknownState))
        mainCoroutineRule.advanceTimeBy(600)
        assertThat(simpleBloc.state.value, IsEqual(EndState))
        mainCoroutineRule.resumeDispatcher()
    }

    // TODO: Expand tests
}
