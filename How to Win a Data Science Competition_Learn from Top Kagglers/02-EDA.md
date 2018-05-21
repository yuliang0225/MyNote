# Exploratory Data Analysis
## 1. Exploratory Data Analysis (EDA): what and why?
---
### EDA allows to:
- Better understand the data
- Build an intuition about the data
- Generate hypothesizes
- Find insights
- Visualizations -> Idea
- **Please, do not start with stacking...**

### With EDA we can:
- Get comfortable with the data
- Find magic features
- **Do EDA first. Do not immediately dig into modelling.**

### Building intuition about the data
#### Getting domain knowledge
- It helps to deeper understand the problem

#### Checking if the data is intuitive
- And agrees with domain knowledge
- Typo or outside, or we misinterpret the feature
- Genreate Features 'is_incorrect'

#### Understanding how the data was generated.
- As it is crucial to set up a proper validation
- It is crucial to understand the generation process to set up a proper validation scheme

### Exploring anonymized data
#### Anonymized data
- Encoded text

##### Explore individual features
- Guess the meaning of the columns: Try to decode the features.
- Guess the types of the column: Each type needs its own preprocessing.
- `df.dtypes df.info() x.value_counts() x.isnull()`

##### Explore feature relations
- Find relations between pairs
- Find feature groups
---
## 2. Things to explore
## 3. Exploration and visualization tools
### Visualization tools to...
#### Explore individual features
- Histograms `plt.hist(x)`
- Plots `plt.plot(x,’.’)` `plt.scatter(range(len(x)), x, c=y)`
- Statistics `df.describe() x.mean() x.var() x.value_counts() x.isnull()`

#### Explore feature relations
- Scatter plots `plt.scatter(x1, x2) pd.scatter_matrix(df)`
- Correlation plots `df.corr(), plt.matshow( ... )`
- Plot (index vs feature statistics)  `df.mean().plot(style=’.’) df.mean().sort_values().plot(style=’.’)`
- And more
##### Pairs
- Scatter plot, scatter matrix
- Corrplot
##### Groups
- Corrplot + clustering
- Plot (index vs feature statistics)
---
## 4. (A bit of) dataset cleaning
### Duplicated and constant features
- `traintest.nunique(axis=1) == 1`
- `traintest.T.drop_duplicates()`
- `for f in categorical_feats: traintest[f] =raintest[f].factorize() traintest.T.drop_duplicates()`
- Check if same rows have same label
- Find duplicated rows, understand why they are duplicated
---
###  Check if dataset is shuffled
### EDA check list
- Get domain knowledge
- Check if the data is intuitive
- Understand how the data was generated
- Explore individual features
- Explore pairs and groups
- Clean features up
- Check for leaks!
---
# Validation and overfitting
## Underfitting and overfitting
**Overfitting in general != overfitting in competitions**
### 1. Validation helps us evaluate a quality of the model
### 2. Validation helps us select the model which will perform best on the unseen data
### 3. Underfitting refers to not capturing enough patterns in the data
### 4. Generally, overfitting refers to
- a. capturing noize
- b. capturing patterns which do not generalize to test data

### 5. In competitions, overfitting refers to
- a. low model’s quality on test data, which was unexpected due to validation scores
---
## Validation strategies
### Validation types
#### Holdout
- ngroups = 1 `sklearn.model_selection.ShuffleSplit`
#### K-fold
- ngroups = k `sklearn.model_selection.Kfold`
#### Leave-one-out
- ngroups = len(train) `sklearn.model_selection.LeaveOneOut`

#### Stratification preserve the same target distribution over different folds
##### Stratification is useful for:
- Small datasets
- Unbalanced datasets
- Multiclass classification

### Data splitting strategies
**Set up validation to replicate train/test split**
- Previous and next target values
- Time-based trend
#### Different splitting strategies can differ significantly
- in generated features
- in a way the model will rely on that features
- in some kind of target leak

#### Splitting data into train and validation
- Random, rowwise
- Timewise: Moving window validation
- By id
- Combined

### Conclusion
#### In most cases data is split by
- a. Rownumber
- b. Time
- c. Id

#### Logic of feature generation depends on the data splitting strategy
#### Set up your validation to mimic the train/test split of the competition

### Common validation problems
#### Causes of different scores and optimal parameters
- Too little data
- Too diverse and inconsistent data

#### We should do extensive validation
- Average scores from different KFold splits
- Tune model on one split, evaluate score on the other

#### We can observe that:
- LB score is consistently higher/lower that validation score
- LB score is not correlated with validation score at all

#### We may already have quite different scores in Kfold
- too little data in public leaderboard
- train and test data are from different distributions

#### Different distributions
- Mean for train: Calculate from the train data
- Mean for test: Leaderboard probing

#### Causes of validation problems:
- too little data in public leaderboard
- incorrect train/test split
- different distributions in train and test

#### Expect LB shuffle because of
- Randomness
- Little amount of data
- Different public/private distributions

#### Conclusion
##### 1. If we have big dispersion of scores on validation stage, we should do extensive validation
- Average scores from different KFold splits
- Tune model on one split, evaluate score on the other

##### 2. If submission’s score do not match local validation score, we should
- Check if we have too little data in public LB – Check if we overfitted
- Check if we chose correct splitting strategy – Check if train/test have different distibutions

##### 3. Expect LB shuffle because of
- Randomness
- Little amount of data
- Different public/private distributions

### Summary of Validation topic
- Defined validation and its connection to overfitting
- Described common validation strategies
- Demonstrated major data splitting strategies
- Analysed and learn how to tackle main validation problems
