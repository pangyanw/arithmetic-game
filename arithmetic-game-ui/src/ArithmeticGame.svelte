<script>
  let question = {};
  let userAnswer = '';
  let result = '';

  async function fetchQuestion() {
    const response = await fetch('http://localhost:8180/question');
    question = await response.json();
    result = '';
    userAnswer = ''; // Reset userAnswer when fetching a new question
  }

  async function submitAnswer() {
    if (parseInt(userAnswer) === question.answer) {
      result = 'Correct';
    } else {
      result = `The answer is ${question.answer}`;
    }
  }
</script>

<main>
  <h1>Arithmetic Quiz</h1>
  {#if !question.answer}
    <button on:click={fetchQuestion}>Start</button>
  {:else}
    <p>
    {#if question.a === -99999}
      <input type="number" bind:value={userAnswer} />
    {:else}
      {question.a}
    {/if}
    +
    {#if question.b === -99999}
      <input type="number" bind:value={userAnswer} />
    {:else}
      {question.b}
    {/if}
    +
    {#if question.c === -99999}
      <input type="number" bind:value={userAnswer} />
    {:else}
      {question.c}
    {/if}
    =
    {#if question.d === -99999}
      <input type="number" bind:value={userAnswer} />
    {:else}
      {question.d}
    {/if}
    </p>
    <button on:click={submitAnswer}>Submit</button>
    <p>{result}</p>
    <button on:click={fetchQuestion}>Next</button>
  {/if}
</main>
