function toggleRecurringFields() {
    const recurring = document.getElementById('recurring').value;
    const recurringFields = document.getElementById('recurring-fields');

    if (recurring === 'yes') {
        recurringFields.style.display = 'block';
    } else {
        recurringFields.style.display = 'none';
    }
}