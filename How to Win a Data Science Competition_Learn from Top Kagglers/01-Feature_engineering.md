# Feature Preprocessing and Generation with Respect to Models
---

## Numeric features
### 1. Preprocessing
#### Scaling
- To[0,1] `sklearn.preprocessing.MinMaxScaler`
- To mean=0, std=1 `sklearn.preprocessing.StandardScaler`

#### Outliers

#### Rank
- `scipy.stats.rankdata`

#### Log transform
- `np.log(1 + x)`

#### Raising to the power<1
- `np.sqrt(x + 2/3)`

### 2. Feature generation
#### Ways to proceed
- Prior knowledge
- EDA.

#### Combined
- `Combined = (horizontal ** 2 + vectical ** 2) ** 0.5`
- **Fractional_part**

### 3. Conclusion

#### 1. Numeric feature preprocessing is different for tree and non-tree models:
a. Tree-based models doesn’t depend on scaling (RF,XGBoost,LightGB...)

b. Non-tree-based models hugely depend on scaling (SVM,KNN,ANN...)

#### 2. Most often used preprocessings are:
a. MinMaxScaler - to [0,1]

b. StandardScaler - to mean==0, std==1

c. Rank - sets spaces between sorted values to be equal

d. np.log(1+x) and np.sqrt(1+x)

#### 3. Feature generation is powered by:
a. Prior knowledge

b. Exploratory data analysis

## Categorical and ordinal features
### Label encoding

#### 1. Alphabetical (sorted) `sklearn.preprocessing.LabelEncoder`
[S,C,Q] -> [2, 1, 3]
#### 2. Order of appearance `Pandas.factorize`
[S,C,Q] -> [1, 2, 3]
#### 3. Frequency encoding
[S,C,Q] -> [0.5, 0.3, 0.2]

- `encoding = titanic.groupby(‘Embarked’).size()`
- `encoding = encoding/len(titanic)`
- `titanic[‘enc’] = titanic.Embarked.map(encoding)`
- `from scipy.stats import rankdata`

### Categorical features
#### One-hot encoding
- `pandas.get_dummies`
- `sklearn.preprocessing.OneHotEncoder`

#### Catboost(Coming soon)

### Conclusion
1. Values in ordinal features are sorted in some meaningful order
2. Label encoding maps categories to numbers
3. Frequency encoding maps categories to their frequencies
4. Label and Frequency encodings are often used for tree-
based models
5. One-hot encoding is often used for non-tree-based models
6. Interactions of categorical features can help linear models
and KNN

## Datetime and coordinates
### 1. Periodicity:
Day number in week, month, season, year second, minute, hour.
### 2. Time since
- a. Row-independent moment. For example: since 00:00:00 UTC, 1 January 1970;
- b. Row-dependent important moment. Number of days left until next holidays/ time passed after last holiday.
### 3. Difference between dates
- Diff = Datetime_feature_1 - Datetime_feature_2

### Coordinates
#### 1. Additional data
#### 2. Other train samples and centers of clusters
#### 3. Aggregated stats
#### 4. Coordinates rotate**

### Conclusion
#### 1. Datetime
- a. Periodicity
- b. Time since row-independent/dependent event
- c. Difference between dates

#### 2. Coordinates
- a. Interesting places from train/test data or additional data
- b. Centers of clusters
- c. Aggregated statistics

## Missing values
### Fillna approaches
1. -999, -1, etc Outside
2. mean, median
3. Reconstruct value

### Method
#### Generate “Isnull” feature**
#### Missing values reconstruction
#### Feature generation with missing values
#### Treating values which do not present in train data **
1. The choice of method to fill NaN depends on the situation
2. Usual way to deal with missing values is to replace them with -999, mean or median
3. Missing values already can be replaced with something by organizers
4. Binary feature “isnull” can be beneficial
5. In general, avoid filling nans before feature generation
6. Xgboost can handle NaN

## Feature extraction from texts and images
- Common features + text
- Common features + images/text

### Text -> vector
#### 1. Bag of words
##### CountVectorizer (Encodeer)
##### TFiDF
- Term frequency
`tf = 1 / x.sum(axis=1) [:,None] x = x * tf`
- Inverse Document Frequency
`idf = np.log(x.shape[0] / (x > 0).sum(0)) x = x * idf`
- `sklearn.feature_extraction.text.TfidfVectorizer`

##### N-grams
- `sklearn.feature_extraction.text.CountVectorizer:`
- `Ngram_range, analyzer`

##### Texts preprocessing
###### Lowercase
###### Lemmatization
- democracy, democratic, and democratization -> democracy
- Saw -> see or saw (depending on context)
###### Stemming
- democracy, democratic, and democratization -> democr
- Saw -> s
###### Stopwords
- Articles or prepositions
- Very common words
##### NLTK, Natural Language Toolkit library for python
- `sklearn.feature_extraction.text.CountVectorizer:max_df`
##### Conclusion: Pipeline of applying BOW
###### Preprocessing:
- Lowercase, stemming, lemmatization, stopwords
###### Bag of words:
- Ngrams can help to use local context
###### Postprocessing:
- TFiDF

#### 2. Embeddings (~word2vec):
- Words: Word2vec, Glove, FastText, etc
- Sentences: Doc2vec, etc
- There are pretrained models

#### 3. BOW and w2v comparison
##### Bag of words
- a. Very large vectors
- b. Meaning of each value in vector is known

##### Word2vec
- Relatively small vectors
- Values in vector can be interpreted only in some cases
- The words with similar meaning often have similar embeddings

### Image -> vector
#### 1. Descriptors
#### 2. Train network from scratch
#### 3. Finetuning VGG-16 Keras
- Small data set: rotate thw image for sample generation
- No for validation sets
- Prevent overfitting

### Feature extraction from text and images
#### Texts
##### a. Preprocessing
- i. Lowercase, stemming, lemmarization, stopwords

##### b.Bag of words
- i. Huge vectors
- ii. Ngrams can help to use local context
- iii. TFiDF can be of use as postprocessing

##### c. Word2vec
- i. Relatively small vectors
- ii. Pretrained models

#### Images
- a. Features can be extracted from different layers
- b. Careful choosing of pretrained network can help
- c. Finetuning allows to refine pretrained models
- d. Data augmentation can improve the model
